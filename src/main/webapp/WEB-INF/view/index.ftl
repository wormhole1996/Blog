<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/custom/css/index.css">
    <script src="/static/jquery/jquery.min.js"></script>
    <script src="/static/bootstrap/js/bootstrap.min.js"></script>
    <script src="/static/custom/js/index.js"></script>
    <script src="/static/knockout/knockout-3.4.2.js"></script>
    <script src="/static/layer/layer.js"></script>
    <title>溢栈</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <div class="side" data-bind="with:sideInfo">
                <img src="" id="head" class="rounded-circle" data-bind="attr:{src:headUrl}">
                <div class="nickname" id="nickname" data-bind="text:nickname"></div>
                <hr/>
                <div class="signature" id="signature" data-bind="text:signature"></div>
                <div class="menu">
                    <a class="item select btn" href="/">
                        首页
                    </a>
                    <a class="item btn">
                        归档
                    </a>
                    <a class="item btn">
                        分类
                    </a>
                    <a class="item btn">
                        与我聊聊
                    </a>
                    <a class="item btn">
                        留言板
                    </a>
                    <a class="item btn">
                        友情链接
                    </a>
                </div>
            </div>
        </div>
        <div class="col-md-9">
            <div class="body">
                <div class="head">
                    最新文章
                </div>
                <div class="article-list" data-bind="foreach:articleList">
                    <div class="article">
                        <div class="title"><a href="" data-bind="text:title,attr:{href:url}"></a></div>
                        <div class="content" data-bind="text:articleHtml"></div>
                        <div class="footer">
                            <div class="row">
                                <div class="col-sm-4">
                                    <span id="date" data-bind="text:date"></span>
                                </div>
                                <div class="col-sm-4">
                                    作者：<span id="author" data-bind="text:nickname"></span>
                                </div>
                                <div class="col-sm-4">
                                    分类：<span id="category" data-bind="text:categoryName"></span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="buttom">
            </div>
            <div class="padding">
            </div>
        </div>
    </div>
</div>
<footer>copyright &copy; 2018 by 溢栈</footer>
</body>
</html>