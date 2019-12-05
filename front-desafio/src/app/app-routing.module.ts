import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GerenciarFuncionarioListComponent } from './gerenciar-funcionario/gerenciar-funcionario-list/gerenciar-funcionario-list.component';
import { GerenciarEmpresaListComponent } from './gerenciar-empresa/gerenciar-empresa-list/gerenciar-empresa-list.component';

const routes: Routes = [
  { path: '', component: GerenciarEmpresaListComponent },
  { path: 'empresa', component: GerenciarEmpresaListComponent },
  { path: 'funcionario', component: GerenciarFuncionarioListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
