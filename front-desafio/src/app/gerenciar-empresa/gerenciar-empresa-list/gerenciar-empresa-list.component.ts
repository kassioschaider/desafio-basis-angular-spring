import { Component, OnInit } from '@angular/core';
import { Empresa } from '../models/empresa.model';
import { GerenciarEmpresaService } from '../gerenciar-empresa.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'gerenciar-empresa-list',
  templateUrl: './gerenciar-empresa-list.component.html',
  styleUrls: ['./gerenciar-empresa-list.component.css']
})
export class GerenciarEmpresaListComponent implements OnInit {

  empresas: Empresa[];
  idEmpresaSelecionadaDelete: number;
  formulario: FormGroup;
  alerta: string = '';

  constructor(
    private empresaService: GerenciarEmpresaService,
    private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.carregarTabelaEmpresas();
    this.formulario = this.formBuilder.group({
      id: [null],
      nome: [null,
        [Validators.min(3), Validators.maxLength(50), Validators.required]],
      cnpj: [null,
        [Validators.maxLength(14), Validators.required]],
      endereco:
        [null, [Validators.min(3), Validators.required, Validators.maxLength(100)]]
    });
  }

  carregarTabelaEmpresas() {
    this.empresaService.obterTodos()
      .subscribe(dados => { this.empresas = <Empresa[]>dados });
  }

  onSubmit() {
    if (!this.formulario.value.id) {
      this.empresaService
        .cadastrar(this.formulario.value)
        .subscribe(resposta => {
          this.empresas.push(Object.assign({}, <Empresa>resposta));
          alert("Empresa " + <Empresa>resposta.nome + " cadastrada com sucesso!");
          this.resetarFormulario();
        }, (err: HttpErrorResponse) => {
          err.error.forEach(e => {
            this.alerta = this.alerta + e.campo + " - " + e.erro + "\n";
          })
          alert(this.alerta);
          this.alerta = '';
        });
    } else {
      this.empresaService
        .atualizar(this.formulario.value)
        .subscribe(resposta => {
          this.empresas.push(Object.assign({}, <Empresa>resposta));
          this.carregarTabelaEmpresas();
          alert("Empresa " + <Empresa>resposta.nome + " atualizada com sucesso!");
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
    this.empresaService.excluirPorId(this.idEmpresaSelecionadaDelete)
      .subscribe();
    this.empresas.splice(this.idEmpresaSelecionadaDelete);
    alert("Empresa excluída com sucesso!");
    this.carregarTabelaEmpresas();
    return false;
  }

  abrirModalConfirmacaoExclusao(id: number) {
    this.idEmpresaSelecionadaDelete = id;
    return true;
  }

  abrirModalComEmpresaSelecionada(empresaSelecionada) {
    this.formulario.controls.id.setValue(empresaSelecionada.id);
    this.formulario.controls.nome.setValue(empresaSelecionada.nome);
    this.formulario.controls.cnpj.setValue(empresaSelecionada.cnpj);
    this.formulario.controls.endereco.setValue(empresaSelecionada.endereco);
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
