<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3>��� ���</h3>
	<form action="main" method="POST">
		<input type="hidden" name="action" value="regist">
		<label>�̸� : </label>
		<input type="text" placeholder="�̸��� �Է��ϼ���" name="name"><br>
		<label>���� : </label>
		<input type="number" min="0" placeholder="���̸� �Է��ϼ���" name="age"><br>
		<input type="radio" id="man" name="gender" value="man">
		<label for="man">����</label>
		<input type="radio" id="woman" name="gender" value="woman">
		<label for="woman">����</label>
		
		<fieldset>
			<legend>���</legend>
			<input type="checkbox" id="sleep" name="hobby" value="sleep">
			<label for="sleep">����</label>
			<input type="checkbox" id="eat" name="hobby" value="eat">
			<label for="eat">�Ա�</label>
			<input type="checkbox" id="study" name="hobby" value="study">
			<label for="study">����</label>
			<input type="checkbox" id="jump" name="hobby" value="jump">
			<label for="jump">����</label>
		</fieldset>
		<input type="submit">
	</form>
</body>
</html>