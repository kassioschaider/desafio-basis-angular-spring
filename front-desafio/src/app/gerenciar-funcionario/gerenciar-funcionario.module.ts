import { NgModule } from '@angular/core';
import { GerenciarFuncionarioListComponent } from './gerenciar-funcionario-list/gerenciar-funcionario-list.component';
import { CommonModule } from '@angular/common';

@NgModule({
  declarations: [GerenciarFuncionarioListComponent],
  imports: [CommonModule],
  exports: [GerenciarFuncionarioListComponent]
})
export class GerenciarFuncionarioModule {

}
