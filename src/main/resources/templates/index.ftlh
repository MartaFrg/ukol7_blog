[#ftl]
<!DOCTYPE html>
<html lang="cs">
<head>
    <meta charset="UTF-8">
    <title>Můj blog</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="/images/favicon.png">
</head>
<body>
    <h1>Toto je můj blog…</h1>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Titulek</th>
                <th scope="col">Popis</th>
                <th scope="col">Autor</th>
                <th scope="col">Datum</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            [#list ListOfPosts as post]
                <tr>
                    <td><a href="/${post.slug}">${post.title}</a></td>
                    <td>${post.perex?no_esc}</td>
                    <td>${post.author}</td>
                    <td>${post.published?date?string}</td>
                </tr>
            [/#list]
            </tbody>
        </table>
</body>
</html>
