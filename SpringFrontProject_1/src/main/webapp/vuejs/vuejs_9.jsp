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
</style>
<script src="https://unpkg.com/vue@3"></script>
</head>
<body>
	<div class="container">
	 <div class="row">
	  <input type=text size=20 class="input-sm" v-model="fd" ref="fd">
	  <input type=button class="btn-sm btn-danger" value="검색"
	   @click="find()"
	  >
	 </div>
	</div>
	<script>
	/*
		new Vue({
			el:'제어하는 태그 영역', => #app
			data:{}
		})
	*/
	 let app=Vue.createApp({
		data():{
			return{
				fd:''
			}
		},
		methods:{
			// id => ref의 속성을 이용
			// this.$refs.ref명.focus(), value... => input tag 제어
			// => e.target.value => React
			// => $('#fd').val() => jquery
			find(){
				let fds=this.$refs.fd.value
				if(fds===""){
					alert("검색어 입력")
					this.$refs.fd.focus()
					return
				}
				alert("검색어:"+this.fd)
			}
		}
	 }).mount('.container')
	</script>
</body>
</html>























