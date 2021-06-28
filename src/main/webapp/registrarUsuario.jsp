<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.3/css/all.css"
	integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk"
	crossorigin="anonymous">
</head>

<body class="w-6/12 mx-auto">
	<div class="grid mt-8  gap-8 grid-cols-1">
		<div class="flex flex-col ">
			<div class="bg-white shadow-md rounded-3xl p-5">
				<div class="flex flex-col sm:flex-row items-center">
					<h2 class="font-semibold text-lg mr-auto">Registro de usuario</h2>
					<div class="w-full sm:w-auto sm:ml-auto mt-3 sm:mt-0"></div>
				</div>
				<div class="mt-5">
					<form class="form" action="/final-web/registro" method="post">
						<div class="md:flex flex-row md:space-x-4 w-full text-xs">
							<div class="mb-3 space-y-2 w-full text-xs">
								<label class="font-semibold text-gray-600 py-2">Usuario
									<abbr title="required">*</abbr>
								</label> <input
									class="appearance-none block w-full bg-grey-lighter text-grey-darker border border-grey-lighter rounded-lg h-10 px-4"
									name="usuario" required="required" type="text">
							</div>
							<div class="mb-3 space-y-2 w-full text-xs">
								<label class="font-semibold text-gray-600 py-2">Email <abbr
									title="required">*</abbr></label> <input
									class="appearance-none block w-full bg-grey-lighter text-grey-darker border border-grey-lighter rounded-lg h-10 px-4"
									name="email" required="required" type="text">
							</div>
						</div>
						<div class="md:flex flex-row md:space-x-4 w-full text-xs">
							<div class="mb-3 space-y-2 w-full text-xs">
								<label class="font-semibold text-gray-600 py-2">Pass <abbr
									title="required">*</abbr></label> <input
									class="appearance-none block w-full bg-grey-lighter text-grey-darker border border-grey-lighter rounded-lg h-10 px-4"
									name="pass" required="required" type="password">
							</div>
							<div class="mb-3 space-y-2 w-full text-xs">
								<label class="font-semibold text-gray-600 py-2">Rol <abbr
									title="required">*</abbr></label> <select
									class="block w-full bg-grey-lighter text-grey-darker border border-grey-lighter rounded-lg h-10 px-4 md:w-full "
									name="rol" required="required">
									<option value="">Seleccione una elección</option>
									<c:forEach var="rol" items="${roles}">
										<option value="<c:out value='${rol.id}'/>"><c:out
												value="${rol.description}" /></option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div
							class="mt-5 text-right md:space-x-3 md:block flex flex-col-reverse">
							<button
								class="mb-2 md:mb-0 bg-green-400 px-5 py-2 text-sm shadow-sm font-medium tracking-wider text-white rounded-full hover:shadow-lg hover:bg-green-500">Registrar</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>

</html>