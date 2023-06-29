<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List, model.Tarefa, java.sql.Date"%>

<!doctype html>
<html lang="en" data-bs-theme="auto">
  <head><script src="/docs/5.3/assets/js/color-modes.js"></script>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.111.3">
    <title>Pagina Principal</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
	
    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/headers/">
    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/album/">

<link href="/docs/5.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

    <!-- Favicons -->
<link rel="apple-touch-icon" href="/docs/5.3/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
<link rel="icon" href="/docs/5.3/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
<link rel="icon" href="/docs/5.3/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
<link rel="manifest" href="/docs/5.3/assets/img/favicons/manifest.json">
<link rel="mask-icon" href="/docs/5.3/assets/img/favicons/safari-pinned-tab.svg" color="#712cf9">
<link rel="icon" href="/docs/5.3/assets/img/favicons/favicon.ico">
<meta name="theme-color" content="#712cf9">


    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }

      .b-example-divider {
        width: 100%;
        height: 3rem;
        background-color: rgba(0, 0, 0, .1);
        border: solid rgba(0, 0, 0, .15);
        border-width: 1px 0;
        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
      }

      .b-example-vr {
        flex-shrink: 0;
        width: 1.5rem;
        height: 100vh;
      }

      .bi {
        vertical-align: -.125em;
        fill: currentColor;
      }

      .nav-scroller {
        position: relative;
        z-index: 2;
        height: 2.75rem;
        overflow-y: hidden;
      }

      .nav-scroller .nav {
        display: flex;
        flex-wrap: nowrap;
        padding-bottom: 1rem;
        margin-top: -1px;
        overflow-x: auto;
        text-align: center;
        white-space: nowrap;
        -webkit-overflow-scrolling: touch;
      }

      .btn-bd-primary {
        --bd-violet-bg: #712cf9;
        --bd-violet-rgb: 112.520718, 44.062154, 249.437846;

        --bs-btn-font-weight: 600;
        --bs-btn-color: var(--bs-white);
        --bs-btn-bg: var(--bd-violet-bg);
        --bs-btn-border-color: var(--bd-violet-bg);
        --bs-btn-hover-color: var(--bs-white);
        --bs-btn-hover-bg: #6528e0;
        --bs-btn-hover-border-color: #6528e0;
        --bs-btn-focus-shadow-rgb: var(--bd-violet-rgb);
        --bs-btn-active-color: var(--bs-btn-hover-color);
        --bs-btn-active-bg: #5a23c8;
        --bs-btn-active-border-color: #5a23c8;
      }
      .bd-mode-toggle {
        z-index: 1500;
      }
      
      .hidden {
      	display: none;
      }
      
    </style>

    
    <!-- Custom styles for this template -->
    <link href="headers.css" rel="stylesheet">
  </head>
  <body>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    <svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
      <symbol id="check2" viewBox="0 0 16 16">
        <path d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z"/>
      </symbol>
      <symbol id="circle-half" viewBox="0 0 16 16">
        <path d="M8 15A7 7 0 1 0 8 1v14zm0 1A8 8 0 1 1 8 0a8 8 0 0 1 0 16z"/>
      </symbol>
      <symbol id="moon-stars-fill" viewBox="0 0 16 16">
        <path d="M6 .278a.768.768 0 0 1 .08.858 7.208 7.208 0 0 0-.878 3.46c0 4.021 3.278 7.277 7.318 7.277.527 0 1.04-.055 1.533-.16a.787.787 0 0 1 .81.316.733.733 0 0 1-.031.893A8.349 8.349 0 0 1 8.344 16C3.734 16 0 12.286 0 7.71 0 4.266 2.114 1.312 5.124.06A.752.752 0 0 1 6 .278z"/>
        <path d="M10.794 3.148a.217.217 0 0 1 .412 0l.387 1.162c.173.518.579.924 1.097 1.097l1.162.387a.217.217 0 0 1 0 .412l-1.162.387a1.734 1.734 0 0 0-1.097 1.097l-.387 1.162a.217.217 0 0 1-.412 0l-.387-1.162A1.734 1.734 0 0 0 9.31 6.593l-1.162-.387a.217.217 0 0 1 0-.412l1.162-.387a1.734 1.734 0 0 0 1.097-1.097l.387-1.162zM13.863.099a.145.145 0 0 1 .274 0l.258.774c.115.346.386.617.732.732l.774.258a.145.145 0 0 1 0 .274l-.774.258a1.156 1.156 0 0 0-.732.732l-.258.774a.145.145 0 0 1-.274 0l-.258-.774a1.156 1.156 0 0 0-.732-.732l-.774-.258a.145.145 0 0 1 0-.274l.774-.258c.346-.115.617-.386.732-.732L13.863.1z"/>
      </symbol>
      <symbol id="sun-fill" viewBox="0 0 16 16">
        <path d="M8 12a4 4 0 1 0 0-8 4 4 0 0 0 0 8zM8 0a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 0zm0 13a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 13zm8-5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2a.5.5 0 0 1 .5.5zM3 8a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2A.5.5 0 0 1 3 8zm10.657-5.657a.5.5 0 0 1 0 .707l-1.414 1.415a.5.5 0 1 1-.707-.708l1.414-1.414a.5.5 0 0 1 .707 0zm-9.193 9.193a.5.5 0 0 1 0 .707L3.05 13.657a.5.5 0 0 1-.707-.707l1.414-1.414a.5.5 0 0 1 .707 0zm9.193 2.121a.5.5 0 0 1-.707 0l-1.414-1.414a.5.5 0 0 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .707zM4.464 4.465a.5.5 0 0 1-.707 0L2.343 3.05a.5.5 0 1 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .708z"/>
      </symbol>
    </svg>
    
<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
  <symbol id="bootstrap" viewBox="0 0 118 94">
    <title>Bootstrap</title>
    <path fill-rule="evenodd" clip-rule="evenodd" d="M24.509 0c-6.733 0-11.715 5.893-11.492 12.284.214 6.14-.064 14.092-2.066 20.577C8.943 39.365 5.547 43.485 0 44.014v5.972c5.547.529 8.943 4.649 10.951 11.153 2.002 6.485 2.28 14.437 2.066 20.577C12.794 88.106 17.776 94 24.51 94H93.5c6.733 0 11.714-5.893 11.491-12.284-.214-6.14.064-14.092 2.066-20.577 2.009-6.504 5.396-10.624 10.943-11.153v-5.972c-5.547-.529-8.934-4.649-10.943-11.153-2.002-6.484-2.28-14.437-2.066-20.577C105.214 5.894 100.233 0 93.5 0H24.508zM80 57.863C80 66.663 73.436 72 62.543 72H44a2 2 0 01-2-2V24a2 2 0 012-2h18.437c9.083 0 15.044 4.92 15.044 12.474 0 5.302-4.01 10.049-9.119 10.88v.277C75.317 46.394 80 51.21 80 57.863zM60.521 28.34H49.948v14.934h8.905c6.884 0 10.68-2.772 10.68-7.727 0-4.643-3.264-7.207-9.012-7.207zM49.948 49.2v16.458H60.91c7.167 0 10.964-2.876 10.964-8.281 0-5.406-3.903-8.178-11.425-8.178H49.948z"></path>
  </symbol>
  <symbol id="home" viewBox="0 0 16 16">
    <path d="M8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4.5a.5.5 0 0 0 .5-.5v-4h2v4a.5.5 0 0 0 .5.5H14a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146zM2.5 14V7.707l5.5-5.5 5.5 5.5V14H10v-4a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5v4H2.5z"/>
  </symbol>
  <symbol id="speedometer2" viewBox="0 0 16 16">
    <path d="M8 4a.5.5 0 0 1 .5.5V6a.5.5 0 0 1-1 0V4.5A.5.5 0 0 1 8 4zM3.732 5.732a.5.5 0 0 1 .707 0l.915.914a.5.5 0 1 1-.708.708l-.914-.915a.5.5 0 0 1 0-.707zM2 10a.5.5 0 0 1 .5-.5h1.586a.5.5 0 0 1 0 1H2.5A.5.5 0 0 1 2 10zm9.5 0a.5.5 0 0 1 .5-.5h1.5a.5.5 0 0 1 0 1H12a.5.5 0 0 1-.5-.5zm.754-4.246a.389.389 0 0 0-.527-.02L7.547 9.31a.91.91 0 1 0 1.302 1.258l3.434-4.297a.389.389 0 0 0-.029-.518z"/>
    <path fill-rule="evenodd" d="M0 10a8 8 0 1 1 15.547 2.661c-.442 1.253-1.845 1.602-2.932 1.25C11.309 13.488 9.475 13 8 13c-1.474 0-3.31.488-4.615.911-1.087.352-2.49.003-2.932-1.25A7.988 7.988 0 0 1 0 10zm8-7a7 7 0 0 0-6.603 9.329c.203.575.923.876 1.68.63C4.397 12.533 6.358 12 8 12s3.604.532 4.923.96c.757.245 1.477-.056 1.68-.631A7 7 0 0 0 8 3z"/>
  </symbol>
  <symbol id="table" viewBox="0 0 16 16">
    <path d="M0 2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2zm15 2h-4v3h4V4zm0 4h-4v3h4V8zm0 4h-4v3h3a1 1 0 0 0 1-1v-2zm-5 3v-3H6v3h4zm-5 0v-3H1v2a1 1 0 0 0 1 1h3zm-4-4h4V8H1v3zm0-4h4V4H1v3zm5-3v3h4V4H6zm4 4H6v3h4V8z"/>
  </symbol>
  <symbol id="people-circle" viewBox="0 0 16 16">
    <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
    <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
  </symbol>
  <symbol id="grid" viewBox="0 0 16 16">
    <path d="M1 2.5A1.5 1.5 0 0 1 2.5 1h3A1.5 1.5 0 0 1 7 2.5v3A1.5 1.5 0 0 1 5.5 7h-3A1.5 1.5 0 0 1 1 5.5v-3zM2.5 2a.5.5 0 0 0-.5.5v3a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5v-3a.5.5 0 0 0-.5-.5h-3zm6.5.5A1.5 1.5 0 0 1 10.5 1h3A1.5 1.5 0 0 1 15 2.5v3A1.5 1.5 0 0 1 13.5 7h-3A1.5 1.5 0 0 1 9 5.5v-3zm1.5-.5a.5.5 0 0 0-.5.5v3a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5v-3a.5.5 0 0 0-.5-.5h-3zM1 10.5A1.5 1.5 0 0 1 2.5 9h3A1.5 1.5 0 0 1 7 10.5v3A1.5 1.5 0 0 1 5.5 15h-3A1.5 1.5 0 0 1 1 13.5v-3zm1.5-.5a.5.5 0 0 0-.5.5v3a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5v-3a.5.5 0 0 0-.5-.5h-3zm6.5.5A1.5 1.5 0 0 1 10.5 9h3a1.5 1.5 0 0 1 1.5 1.5v3a1.5 1.5 0 0 1-1.5 1.5h-3A1.5 1.5 0 0 1 9 13.5v-3zm1.5-.5a.5.5 0 0 0-.5.5v3a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5v-3a.5.5 0 0 0-.5-.5h-3z"/>
  </symbol>
</svg>

  <header class="py-3 mb-3 border-bottom">
    <div class="container-fluid d-grid gap-3 align-items-center" style="grid-template-columns: 1fr 2fr;">
      <img alt="" src="https://media0.giphy.com/media/YOkiiJlAJas6TScPx2/giphy.gif?cid=6c09b952ec2bcdedece041343501c6ee4bb51da170fff146&rid=giphy.gif&ct=s" width="80" height="80" style="border-radius: 50%;">

      <div class="d-flex align-items-center">
        <form class="w-100 me-3" role="search">
          <input type="search" class="form-control" placeholder="Search..." aria-label="Search">
        </form>
        
        <div>
        	<p align="center">${ nome_usuario }</p>
        	<br>
        </div>

        <div class="flex-shrink-0 dropdown">
          <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
            <img src="data:image/jpeg;base64,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" alt="mdo" width="80" height="80" class="rounded-circle">
          </a>
          <ul class="dropdown-menu text-small shadow">
            <li><a class="dropdown-item" href="/SistemaAgenda_EnzoMb_DW1/logout">Logout</a></li>
          </ul>
        </div>
      </div>
    </div>
  </header>
  
  <main>
  
  <section class="py-5 text-center container">
    <div class="row py-lg-5">
      <div class="col-lg-6 col-md-8 mx-auto">
        <h1 class="fw-light">Tarefas</h1>
      </div>
    </div>
  </section>
  
  <div class="album py-5 bg-body-tertiary">
    <div class="container">

      <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
  <% 
	List<Tarefa> lista = (List<Tarefa>) request.getAttribute("tarefas");
	
	if(lista != null) {
	
	for(Tarefa tarefa : lista) {
	
	%>
        <div class="col">
          <div class="card shadow-sm">
            <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title></title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em"><%= tarefa.getTitulo() %></text></svg>
            <div class="card-body">
              <p class="card-text"><%= tarefa.getDescricao() %></p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <a href="/SistemaAgenda_EnzoMb_DW1/mostraTarefa?id_tarefa=<%= tarefa.getId_tarefa() %>&nome_usuario=${nome_usuario}"><button type="button" class="btn btn-sm btn-outline-secondary">Editar</button></a>
                  <a href="/SistemaAgenda_EnzoMb_DW1/removeTarefa?id_tarefa=<%= tarefa.getId_tarefa() %>&id_usuario=${ id_usuario }&nome_usuario=${nome_usuario}"><button type="button" class="btn btn-sm btn-outline-secondary">Remover</button></a>
                </div>
                <small class="text-body-secondary">Criação: <br><%= tarefa.getData_criacao() %></small>
              </div>
            </div>
          </div>
          <small class="text-body-secondary">Status: 
                <% 
					if(tarefa.isStatus()) {
				%>
				Concluido em <%= tarefa.getData_conclusao() %></small>
				<%
					} else {
				%>
				Em andamento</small>
				<%
					}
				%>
        </div>
  <%
	}
	}
  %>
  		</div>
  		<div align="center">
		<a href="/SistemaAgenda_EnzoMb_DW1/registerTarefa?id_usuario=${ id_usuario }&nome_usuario=${nome_usuario}"><button type="button" class="btn btn-sm btn-outline-secondary" style="font-size: 50px; text-decoration: none; border-radius: 30%;">+</button></a>
		<br>
	</div>
    </div>
  </div>

</main>

	<dialog class="dialog-tarefaCadastrada">
      
      	<h1>
      		Tarefa Cadastrada com sucesso!
      	</h1>
      	
      	<button class="close-C">Ok</button>
      
      </dialog>
      
    <dialog class="dialog-tarefaAlterada">
      
      	<h1>
      		Tarefa Alterada com sucesso!
      	</h1>
      	
      	<button class="close-A">Ok</button>
      
      </dialog>
    

    <script src="/docs/5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
 
 	<script>
 	
 		//Script para a pesquisa de uma tarefa!
 		const inputSearchAgenda = document.querySelector('.form-control')
 		const allContainer = document.querySelector('.g-3')
 		
 		const filterTarefas = (tarefas, inputValue, returnMatchedTarefas) => tarefas.filter(tarefa => {
 				const matchedTarefas = tarefa.textContent.substr(0, 50).toLowerCase().includes(inputValue)
 				return returnMatchedTarefas ? matchedTarefas : !matchedTarefas
 		})
 		
 		const hideTarefas = (tarefas, inputValue) => {
 			filterTarefas(tarefas, inputValue, false).forEach(tarefa => { //Desta forma, seleciona apenas o titulo!
 				tarefa.classList.add('hidden')
 			})
 		}
 		
 		const showTarefas = (tarefas, inputValue) => {
 			filterTarefas(tarefas, inputValue, true).forEach(tarefa => { //Desta forma, seleciona apenas o titulo!
 				tarefa.classList.remove('hidden')
 			})
 		}
 		
 		inputSearchAgenda.addEventListener('input', event => {
 			console.log('opa')
 			const inputValue = event.target.value.trim().toLowerCase()
 			const tarefas = Array.from(allContainer.children)
 			
 			hideTarefas(tarefas, inputValue)
 			
 			showTarefas(tarefas, inputValue)
 			
 		})
 		
 		//Script para feedback!
 		const modalCadastro = document.querySelector(".dialog-tarefaCadastrada")
 		const modalAltera = document.querySelector(".dialog-tarefaAlterada")
      	const buttonCloseCadastro = document.querySelector(".dialog-tarefaCadastrada .close-C")
      	const buttonCloseAltera = document.querySelector(".dialog-tarefaAlterada .close-A")
      	
      	buttonCloseCadastro.onclick = function () {
 				modalCadastro.close()
			}
 		
 		buttonCloseAltera.onclick = function () {
 			modalAltera.close()
		}
 		
 		<%
 			boolean mCadastra = (boolean) request.getAttribute("tarefaCadastrada");
 			boolean mAltera = (boolean) request.getAttribute("tarefaAlterada");
 		%>
 		
 		if(<%= mAltera %>) {
 			modalAltera.showModal()
  		}
 		
 		if(<%= mCadastra %>) {
 			modalCadastro.showModal()
  		}
 		
 	</script>
 	
  </body>
</html>
