<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="num" uri="NumDados"%>

<link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
    *{
    position: relative;
    font-family: 'Varela Round';
    }
    body{
        background-position: center;
        background-size: cover;
    }
    .menuitem{
        margin-left: 20px;
        margin-top: 10px;
    }
    #active{
        background-color: #363636;
        border-radius: 6px;
    }
    #menu{
        background-color: #1C1C1C;
        background-image:linear-gradient(to bottom, transparent 1px, rgba(0,0,0,.1) 1px);
    }
    .formpadrao{
        display: inline-flex;
        margin-top: 14px;
        margin-left: 11px;
    }
    .search {
        padding: 8px 15px;
        background: rgba(55, 55, 55, 0.8);
        border: 0px solid #dbdbdb;
        color: #FF6EB4;
    }
    .button {
        position: relative;
        padding: 8px 15px;
        left: -8px;
        border: 2px solid #FF6EB4;
        border-radius: 5px;
        background-color: #DB7093;
        color: #fafafa;
    }
    .button:hover {
        background-color: #fafafa;
        color: #FF6EB4;
    }
    #formBusca{
        width: 255px;
        height: 40px;
		margin-left: 7%;
    }
    #formSair{
        width: 60px;
        height: 40px;
    }
    #nav{
        width: 90%;
        height: 10%;
    }
</style>
<num:numDados retorno="mensagens"/>
<num:numDados retorno="pedidos"/>

<nav class="navbar navbar-inverse" id="menu">
    <ul class="nav navbar-nav" id="nav">
		<li id="active" class="menuitem">
            <a><i> <img src="css/img/icon.svg" width="15px" height="15px"> Thread of Love</i></a>
        </li>
        <li class="menuitem">
            <a href="Inicial.jsp">Perfil do Usuario</a>
        </li>
        <li class="menuitem">
            <a href="Convites.jsp">Convites <span class="badge">${numConv}</span></a>
        </li>
        <li class="menuitem">
            <a href="Mensagens.jsp">Mensagens <span class="badge">${contMensagens}</span></a>
        </li>
        <li class="menuitem"><a href="Galeria.jsp">Galeria</a></li>
        <form method="post" action="front.do" id="formBusca" class="formpadrao">
            <input type="text" name="busca" class="search" placeholder="Busque amigos..." required/>
            <input type="submit" class="button" value="&#128270;"/>
			<input type="hidden" name="action" value="Buscador"/>
        </form>
    </ul>
	<ul class="nav navbar-nav navbar-right" style="margin-right:20px">
        <form action="front.do" method="POST" id="formSair" class="formpadrao">
			<input type="hidden" name="action" value="EncerrarSessao"/>
            <input type="submit" class="button" value="Sair"/>
        </form>
	</ul>
</nav>

