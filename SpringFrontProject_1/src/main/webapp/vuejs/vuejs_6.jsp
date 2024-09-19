<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 50px;
}
.row {
    margin: 0px auto;
    width: 500px;
}
.movieTr:hover{
   cursor: pointer
}

</style>
<script src="https://unpkg.com/vue@3"></script>
</head>
<body>
	<div class="container" id="app1">
	 <h3 class="text-center">조건문(v-if,v-if~v-else)</h3>
	 <div class="row">
	  <input type="button" value="로그인" class="btn btn-sm btn-danger"
	  	@click="login(true)"
	  >
	  <input type="button" value="로그아웃" class="btn btn-sm btn-danger"
	  	@click="login2(false)"
	  >
	  <div v-if="login===true">
	   로그인 완
	  </div>
	  <div v-if="login===false">
	   로그아웃
	  </div>
	 </div>
	</div>
	<div class="container" id="app2">
	 <div class="row">
	  	  <input type="button" value="한식" class="btn btn-sm btn-danger"
	  	  	@click="select(1)"
	  	  >
	  	  <input type="button" value="양식" class="btn btn-sm btn-success"
	  	  	@click="select(2)"
	  	  >
	  	  <input type="button" value="중식" class="btn btn-sm btn-warning"
	  	  	@click="select(3)"
	  	  >
	  	  <input type="button" value="일식" class="btn btn-sm btn-info"
	  	  	@click="select(4)"
	  	  >
	  	  <input type="button" value="분식" class="btn btn-sm btn-primary"
	  	  	@click="select(5)"
	  	  >
	 </div>
	 <div style="height: 10px"></div>
	 <div class="row">
	  <div v-if="type===1">
	   한식 선택
	  </div>
	  <div v-else-if="type===2">
	   양식 선택
	  </div>
	  <div v-else-if="type===3">
	   중식 선택
	  </div>
	  <div v-else-if="type===4">
	   일식 선택
	  </div>
	  <div v-else-if="type===5">
	   분식 선택
	  </div>
	 </div>
	</div>
	<script>
	 let app=vue.createApp({
		 data(){
			 return{
			 login:false
			 }
		 },
		 methods:{
			 login2(log){
				 this.login=log
			 }
		 }
	 }).mount('#app1')
	 
	 let app1=Vue.createApp({
		 data(){
			 return{
				 type:0
			 }
		 },
		 methods:{
			 select(no){
				 this.type=no
			 }
		 }
	 })
	</script>
</body>
</html>
















