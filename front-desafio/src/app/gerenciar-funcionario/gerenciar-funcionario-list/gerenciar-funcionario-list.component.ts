import { Component, OnInit } from '@angular/core';
import { Funcionario } from '../models/funcionario.model';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { GerenciarFuncionarioService } from '../gerenciar-funcionario.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Empresa } from 'src/app/gerenciar-empresa/models/empresa.model';
import { GerenciarEmpresaService } from 'src/app/gerenciar-empresa/gerenciar-empresa.service';
import { ValidateBrService } from 'angular-validate-br';

@Component({
  selector: 'gerenciar-funcionario-list',
  templateUrl: './gerenciar-funcionario-list.component.html',
  styleUrls: ['./gerenciar-funcionario-list.component.css']
})
export class GerenciarFuncionarioListComponent implements OnInit {

  formulario: FormGroup;
  funcionarios: Funcionario[];
  empresas: Empresa[];
  idFuncionarioSelecionadoDelete: number;
  alerta: string = '';

  constructor(
    private funcionarioService: GerenciarFuncionarioService,
    private empresaService: GerenciarEmpresaService,
    private formBuilder: FormBuilder,
    private validateBrService: ValidateBrService) { }

  ngOnInit() {
    this.carregarComboEmpresas();
    this.formulario = this.formBuilder.group({
      id: [null],
      nome: [null,
        [Validators.min(3), Validators.maxLength(50), Validators.required,
        Validators.pattern("^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]*$")]],
      cpf: [null,
        [Validators.maxLength(11), Validators.required,
        this.validateBrService.cpf]],
      dataNascimento:
        [null, [Validators.required]],
      idEmpresa: [null]
    });
  }

  carregarComboEmpresas() {
    this.empresaService.obterTodos()
      .subscribe(dados => {
        this.empresas = <Empresa[]>dados;
        this.carregarTabelaFuncionarios();
      });
  }

  carregarTabelaFuncionarios() {
    this.funcionarioService.obterTodos()
      .subscribe(dados => {
        this.funcionarios = <Funcionario[]>dados;
        this.funcionarios.forEach(f => {
          f.nomeEmpresa = this.buscarEmpresa(f.idEmpresa);
        });
      });
  }

  buscarEmpresa(idEmpresa: number) {
    return this.empresas
      .find(empresa => empresa.id === idEmpresa).nome;
  }

  onSubmit() {
    if (!this.formulario.value.id) {
      this.onCreate();
    } else {
      this.onUpdate();
    }
  }

  onCreate() {
    this.funcionarioService
      .cadastrar(this.formulario.value)
      .subscribe(resposta => {
        resposta.nomeEmpresa = this.buscarEmpresa(resposta.idEmpresa);
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
  }

  onUpdate() {
    this.funcionarioService
      .atualizar(this.formulario.value)
      .subscribe(resposta => {
        resposta.nomeEmpresa = this.buscarEmpresa(resposta.idEmpresa);
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

  abrirModal() {
    return true;
  }

  fecharModal() {
    this.resetarFormulario();
    return false;
  }

  verificaValidTouched(campo) {
    return !this.formulario.get(campo).valid && this.formulario.get(campo).touched;
  }
}
