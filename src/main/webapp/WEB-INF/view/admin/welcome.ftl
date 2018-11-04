<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
    <link rel="stylesheet" href="/static/plugins/layui/css/layui.css"/>
    <link rel="stylesheet" href="/static/admin/css/welcome.css"/>
    <script src="/static/plugins/echarts/echarts.min.js"></script>
    <script src="/static/plugins/layui/layui.js"></script>
    <meta name="keywords" content="${Application.setting.keywords}"/>
    <meta name="description" content="${Application.setting.description}"/>
    <link rel="icon" href="${Application.setting.head}"/>
    <title>${Application.setting.title}</title>
</head>
<body>
<div class="layui-card">
    <div class="layui-card-header">流量分析</div>
    <div class="layui-card-body">
        <div id="flow">

        </div>
    </div>
</div>
<script type="text/javascript" src="/static/admin/js/welcome.js"></script>
</body>
</html>