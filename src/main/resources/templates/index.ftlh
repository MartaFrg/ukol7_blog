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
            [#list ListOfPosts.content]
            <tr>
                <th scope="col">Titulek</th>
                <th scope="col">Popis</th>
                <th scope="col">Autor</th>
                <th scope="col">Datum</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>

                [#items as post]
                <tr>
                    <td><a href="/post/${post.slug}">${post.title}</a></td>
                    <td>${post.perex?no_esc}</td>
                    <td>${post.author}</td>
                    <td>${post.published?date?string}</td>
                </tr>
                [/#items]
            [/#list]
            </tbody>
        </table>
    <div class="pager">
        [@pagerLink page=0 active=false text="⇤" /]
        [@pagerLink page=ListOfPosts.number - 1 active=ListOfPosts.first text="←" /]
        [#list (0..ListOfPosts.totalPages) as pageNumber]
            [@pagerLink page=pageNumber active=pageNumber==ListOfPosts.number text=pageNumber + 1 /]
        [/#list]
        [@pagerLink page=ListOfPosts.number + 1 active=ListOfPosts.last text="→" /]
        [@pagerLink page=ListOfPosts.totalPages - 1 active=false text="⇥" /]
    </div>

</body>
</html>
[#macro pagerLink page text active]
    [#if active]
        <span class="page active">${text}</span>
    [#else ]
        <a href="${createURL({"page": page})}" class="page">${text}</a>
    [/#if]
[/#macro]
