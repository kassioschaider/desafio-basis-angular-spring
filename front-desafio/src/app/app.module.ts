import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GerenciarEmpresaListComponent } from './gerenciar-empresa/gerenciar-empresa-list/gerenciar-empresa-list.component';
import { GerenciarEmpresaFormComponent } from './gerenciar-empresa/gerenciar-empresa-form/gerenciar-empresa-form.component';
import { GerenciarFuncionarioFormComponent } from './gerenciar-funcionario/gerenciar-funcionario-form/gerenciar-funcionario-form.component';
import { GerenciarFuncionarioListComponent } from './gerenciar-funcionario/gerenciar-funcionario-list/gerenciar-funcionario-list.component';

@NgModule({
  declarations: [
    AppComponent,
    GerenciarEmpresaListComponent,
    GerenciarEmpresaFormComponent,
    GerenciarFuncionarioFormComponent,
    GerenciarFuncionarioListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
