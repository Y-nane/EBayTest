# EBayTest
For the interview of EBay

### 使用说明

#### 1、账号信息

项目总共两个请求，请求需要携带 <font color="red">X-user</font> 的header，这里提供两个测试账号

##### 1）admin账号

```txt
加密信息：eyJhY2NvdW50TmFtZSI6Im5hbmUiLCJpZCI6MTIzNDU2LCJyb2xlIjoiYWRtaW4ifQ==
解密信息：User(id=123456, accountName=nane, role=admin)
```

##### 2）user账号

```txt
加密信息：eyJhY2NvdW50TmFtZSI6Im5hbmUiLCJpZCI6MTIzNDU2LCJyb2xlIjoidXNlciJ9
解密信息：User(id=123456, accountName=nane, role=user)
```

#### 2、存储信息

admin 为用户赋予权限时，会将授权的信息存储进项目目录下 userResource/[userId].json 的文件中

