# VirtualDesign
## 自己设计的虚拟主播数据可视化App


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
***
展示几个完成的页面
> 首页四种数据详细图表

![Snipaste_2023-04-13_11-25-28](https://user-images.githubusercontent.com/48997328/232030214-c4b34409-07ef-45e0-be8e-c62e03a1f5ee.jpg)

> 虚拟主播每日每周营收排行

![Snipaste_2023-04-13_11-25-53](https://user-images.githubusercontent.com/48997328/232030484-05ed0b66-67c9-4778-a43a-666693b67eb5.jpg)

> 虚拟主播每日每周涨粉排行

![Snipaste_2023-04-13_11-27-17](https://user-images.githubusercontent.com/48997328/232030531-67c07a44-6642-4bec-bd17-30f67036d9cc.jpg)

> 虚拟主播个人具体数据信息页面

![Snipaste_2023-04-13_11-40-23](https://user-images.githubusercontent.com/48997328/232030598-6f0b68e1-591e-466d-b24f-ea9070dc003f.jpg)

> ChatGPT对话页面

![Snipaste_2023-04-12_22-33-55](https://user-images.githubusercontent.com/48997328/232030657-aa3ec8e5-a1c5-411b-8bbb-8f13265bf904.jpg)

>个人信息页

![Snipaste_2023-04-13_11-25-06](https://user-images.githubusercontent.com/48997328/232030707-ae49dc11-cea1-44c0-a32b-753cc9de6d93.jpg)
***
目前主要的就这些了，后续功能还在继续完善...
