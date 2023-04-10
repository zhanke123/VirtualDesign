# VirtualDesign
## 自己设计的虚拟主播数据可视化App

***

>采用AndroidStudio进行封壳，使用Vue3.0+Typescript做的H5+app

![image](https://user-images.githubusercontent.com/48997328/230912384-b75a0858-a640-43dc-a69a-f603591176ec.png)

自己设计的logo和取的名字，可能有些土- -。
***
![image](https://user-images.githubusercontent.com/48997328/230912308-b954d6b4-da0a-413f-bf46-4a8649e3668d.png)


首页大概是这个样子的，自己设计的也可能有点丑，用的是阿里的图标库加京东vue3移动端UI自带的图标库。

> 自己不会python不能实时爬取b站直播数据，所以采用邪道了

使用的jsoup加token模拟用户登录后权限抓取的各数据网站的接口，之间一直用postman测试接口，然后存放在redis里面，前端随用随取。

具体细节不多说了。

>这里只放了部分后端代码，前端代码就不放了，毕竟还涉及到自己的毕设。

