import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GerenciarEmpresaListComponent } from './gerenciar-empresa/gerenciar-empresa-list/gerenciar-empresa-list.component';
import { GerenciarFuncionarioListComponent } from './gerenciar-funcionario/gerenciar-funcionario-list/gerenciar-funcionario-list.component';

@NgModule({
  declarations: [
    AppComponent,
    GerenciarEmpresaListComponent,
    GerenciarFuncionarioListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
