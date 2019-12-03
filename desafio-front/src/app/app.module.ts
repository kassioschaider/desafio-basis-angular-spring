import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GerenciarEmpresaComponent } from './gerenciar-empresa/gerenciar-empresa.component';
import { GerenciarFuncionarioComponent } from './gerenciar-funcionario/gerenciar-funcionario.component';
import { GerenciarEmpresaFormComponent } from './gerenciar-empresa/gerenciar-empresa-form/gerenciar-empresa-form.component';
import { GerenciarFuncionarioFormComponent } from './gerenciar-funcionario/gerenciar-funcionario-form/gerenciar-funcionario-form.component';
import { GerenciarFuncionarioListComponent } from './gerenciar-funcionario/gerenciar-funcionario-list/gerenciar-funcionario-list.component';
import { GerenciarEmpresaListComponent } from './gerenciar-empresa/gerenciar-empresa-list/gerenciar-empresa-list.component';

@NgModule({
  declarations: [
    AppComponent,
    GerenciarEmpresaComponent,
    GerenciarFuncionarioComponent,
    GerenciarEmpresaFormComponent,
    GerenciarFuncionarioFormComponent,
    GerenciarFuncionarioListComponent,
    GerenciarEmpresaListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
