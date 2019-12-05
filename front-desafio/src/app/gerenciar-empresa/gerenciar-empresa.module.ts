import { NgModule } from '@angular/core';

import { ReactiveFormsModule } from '@angular/forms';
import { GerenciarEmpresaListComponent } from './gerenciar-empresa-list/gerenciar-empresa-list.component';

@NgModule({
  declarations: [GerenciarEmpresaListComponent],
  imports: [ReactiveFormsModule],
  exports: [GerenciarEmpresaListComponent]
})
export class GerenciarEmpresaModule {

}
