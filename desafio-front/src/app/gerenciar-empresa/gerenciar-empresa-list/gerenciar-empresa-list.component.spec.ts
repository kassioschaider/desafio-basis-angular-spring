import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GerenciarEmpresaListComponent } from './gerenciar-empresa-list.component';

describe('GerenciarEmpresaListComponent', () => {
  let component: GerenciarEmpresaListComponent;
  let fixture: ComponentFixture<GerenciarEmpresaListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GerenciarEmpresaListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GerenciarEmpresaListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
