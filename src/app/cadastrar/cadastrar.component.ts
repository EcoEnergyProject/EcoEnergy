import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from '../model/Usuario';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-cadastrar',
  templateUrl: './cadastrar.component.html',
  styleUrls: ['./cadastrar.component.css']
})
export class CadastrarComponent implements OnInit {

  usuario: Usuario = new Usuario();
  confirmarSenha: string;
  tipoUser: string

  constructor(
    private auth: AuthService,
    private router: Router
  ) { }

  ngOnInit(){
    window.scroll(0,0)
  }

  confirmSenha(event: any){
    this.confirmarSenha = event.target.value;
  }

  tipoUsuario(event: any){
    this.tipoUser = event.target.value;
  }

  cadastrar(){
    this.usuario.adm = this.tipoUser

    if(this.usuario.senha != this.confirmarSenha){
      alert("As senhas não coincidem!")
    } else{
      console.log(this.usuario)
      this.auth.cadastrar(this.usuario).subscribe((resp: Usuario) => {
        this.usuario = resp
        this.router.navigate(["/entrar"])
        alert("Usuário cadastrado com sucesso!")
      }, erro =>{
        if(erro.status == 400){
          alert("Essa conta já existe, tente fazer o login!")
          this.router.navigate(["/entrar"])
        }
    })
  }
}
}