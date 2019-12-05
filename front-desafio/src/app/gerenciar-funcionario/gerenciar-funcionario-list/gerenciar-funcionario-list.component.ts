import { Component, OnInit } from '@angular/core';
import { Funcionario } from '../models/funcionario.model';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { GerenciarFuncionarioService } from '../gerenciar-funcionario.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Empresa } from 'src/app/gerenciar-empresa/models/empresa.model';
import { GerenciarEmpresaService } from 'src/app/gerenciar-empresa/gerenciar-empresa.service';

@Component({
  selector: 'gerenciar-funcionario-list',
  templateUrl: './gerenciar-funcionario-list.component.html',
  styleUrls: ['./gerenciar-funcionario-list.component.css']
})
export class GerenciarFuncionarioListComponent implements OnInit {

  funcionarios: Funcionario[];
  empresas: Empresa[];
  idFuncionarioSelecionadoDelete: number;
  formulario: FormGroup;
  alerta: string = '';

  constructor(
    private funcionarioService: GerenciarFuncionarioService,
    private empresaService: GerenciarEmpresaService,
    private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.carregarTabelaFuncionarios();
    this.carregarComboEmpresas();
    this.formulario = this.formBuilder.group({
      id: [null],
      nome: [null,
        [Validators.min(3), Validators.maxLength(50), Validators.required]],
      cpf: [null,
        [Validators.maxLength(11), Validators.required]],
      dataNascimento:
        [null, [Validators.required, Validators.maxLength(8), Validators.min(8)]],
      idEmpresa: [null]
    });
  }

  carregarTabelaFuncionarios() {
    this.funcionarioService.obterTodos()
      .subscribe(dados => { this.funcionarios = <Funcionario[]>dados });
  }

  carregarComboEmpresas() {
    this.empresaService.obterTodos()
      .subscribe(dados => { this.empresas = <Empresa[]>dados });
  }

  onSubmit() {
    if (!this.formulario.value.id) {
      this.funcionarioService
        .cadastrar(this.formulario.value)
        .subscribe(resposta => {
          this.funcionarios.push(Object.assign({}, <Funcionario>resposta));
          alert("Funcionário " + <Funcionario>resposta.nome + " cadastrado com sucesso!");
          this.resetarFormulario();
        }, (err: HttpErrorResponse) => {
          err.error.forEach(e => {
            this.alerta = this.alerta + e.campo + " - " + e.erro + "\n";
          })
          alert(this.alerta);
          this.alerta = '';
        });
    } else {
      this.funcionarioService
        .atualizar(this.formulario.value)
        .subscribe(resposta => {
          this.funcionarios.push(Object.assign({}, <Funcionario>resposta));
          this.carregarTabelaFuncionarios();
          alert("Funcionário " + <Funcionario>resposta.nome + " atualizado com sucesso!");
          this.resetarFormulario();
        }, (err: HttpErrorResponse) => {
          err.error.forEach(e => {
            this.alerta = this.alerta + e.campo + " - " + e.erro + "\n";
          })
          alert(this.alerta);
          this.alerta = '';
        });
    }
  }

  onDelete() {
    this.funcionarioService.excluirPorId(this.idFuncionarioSelecionadoDelete)
      .subscribe();
    this.funcionarios.splice(this.idFuncionarioSelecionadoDelete);
    alert("Funcionário excluído com sucesso!");
    this.carregarTabelaFuncionarios();
    return false;
  }

  abrirModalConfirmacaoExclusao(id: number) {
    this.idFuncionarioSelecionadoDelete = id;
    return true;
  }

  abrirModalComFuncionarioSelecionado(funcionarioSelecionado) {
    this.formulario.controls.id.setValue(funcionarioSelecionado.id);
    this.formulario.controls.nome.setValue(funcionarioSelecionado.nome);
    this.formulario.controls.cpf.setValue(funcionarioSelecionado.cpf);
    this.formulario.controls.dataNascimento.setValue(funcionarioSelecionado.dataNascimento);
    this.formulario.controls.idEmpresa.setValue(funcionarioSelecionado.idEmpresa);
    return true;
  }

  resetarFormulario() {
    this.formulario.reset();
  }

  verificaValidTouched(campo) {
    return !this.formulario.get(campo).valid && this.formulario.get(campo).touched;
  }

  abrirModal() {
    return true;
  }

  fecharModal() {
    this.resetarFormulario();
    return false;
  }
}



