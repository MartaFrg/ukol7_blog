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
<h1>${singlePost.title}</h1>
<strong>${singlePost.perex?no_esc}</strong>
    <div>
        <p>${singlePost.body?no_esc}</p>
        <a href="/">ZPĚT</a>
    </div>
</body>
</html>

