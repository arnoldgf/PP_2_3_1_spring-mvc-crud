<!DOCTYPE html>
<html lang="en" xmlns:th="http://thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Изменение пользователя</title>
</head>
<body>

<form th:method="POST" th:action="@{/users/edit(id=${user.id})}" th:object="${user}">
    <label for="name">Введите имя:</label>
    <input type="text" th:field="*{name}" id="name"/>
    <br/>
    <label for="surname">Введите фамилию:</label>
    <input type="text" th:field="*{surname}" id="surname"/>
    <br/>
    <label for="year">Введите год рождения:</label>
    <input type="text" th:field="*{year}" id="year"/>
    <br/>
    <input type="submit" value="Редактировать!">
</form>
</body>
</html>