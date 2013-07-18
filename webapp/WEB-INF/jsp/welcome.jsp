<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<script type="text/javascript" src="/aaarrgh/js/jquery.js"></script>
		<title>Bienvenido</title>
	</head>
	<body>
		<table>
			<tr style="height: 100px;">
			<td>
				<table>
					<tr style="width; 100%; height: 100%;">
					<td style="width: 50%; text-align: left;">
						Aaarrgh versión 2.0
					</td>
					<td style="width: 50%; text-alig: right;">
						<a href="/aaarrgh/user/QuiroVerMiPerfil.do">Mi perfil</a>
						<br/>
						<a href="/aaarrgh/login/logout.do">Logout</a>
					</td>
					</tr>
				</table>
			</td>
			</tr>
			<tr>
			<td>
				<br/>
				<table>
				<tr style="width; 100%; height: 100%;">
				<td style="width: 50%; height: 100%;">
					<form action="/aaarrgh/message/writeMessage.do" class="form-horizontal" onsubmit="return validateMessage();">
						<input type="text" id="inputMessage" name="message" placeholder="¿Que hay de nuevo marinero?" maxlength="140"/>
					</form>
					<br/>
					<label id="lblAmoutOfCharacters">0/140</label>
					
					<c:forEach items="${m}" var="m">
						<br/>
						<c:out value="${m.mensaje}"/>
						<br/>
					</c:forEach>
				</td>
				<td style="width: 50%; height: 100%;">
					<a href="">A quienes sigo</a>
					<br/>
					<a href="">Quienes me siguen</a>
				</td>
				</tr>
				</table>
			</td>
			</tr>
		</table>
	
	<script type="text/javascript">
	function validateMessage() {
		var textbox = $.trim($('#inputMessage').val());
		if (textbox == "") {
			alert('No puede dejar el mensaje vacío');
			return false;
		}
		return true;
	}
	
	$('#inputMessage').keyup(function() {
		var message = $('#inputMessage').val();
		var label = message.length + '/140';
		$('#lblAmoutOfCharacters').html(label);
	});
	</script>
	
	</body>
</html>
