SecurityConfig现在是直接使用的访问成功进入index页面，jsp页面无拦截，但是index页面中的iframe引用的aaa.html却无响应，一直显示的是登录页面。

我试了一下自定义成功处理类response.sendRedirect("/index")也不起作用。

如果是静态资源页面拦截的话index页面也应该进不去的，但是aaa.html却引用不了，麻烦大佬了，您看一下。

