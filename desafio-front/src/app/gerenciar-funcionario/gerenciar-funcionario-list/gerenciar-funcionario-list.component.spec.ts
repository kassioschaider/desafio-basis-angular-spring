import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GerenciarFuncionarioListComponent } from './gerenciar-funcionario-list.component';

describe('GerenciarFuncionarioListComponent', () => {
  let component: GerenciarFuncionarioListComponent;
  let fixture: ComponentFixture<GerenciarFuncionarioListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GerenciarFuncionarioListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GerenciarFuncionarioListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
