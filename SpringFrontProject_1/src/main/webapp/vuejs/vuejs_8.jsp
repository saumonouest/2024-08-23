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
	<!-- View -->
	<div class="container">
	 <div class="row">
	  <div class="col-sm-4" id="movie1">
	   <table class="table">
	    <caption>주간영화순위</caption>
	    <tr>
	     <th class="text-center"></th>
	     <th class="text-center">영화명</th>
	     <th class="text-center">감독</th>
	    </tr>
	    <tr v-for="m in movie_list">
	     <td class="text-center">
	      <img :src="m.poster" style="width:30px; height:30px">
	     </td>
	     <td>{{m.title}}</td>
	     <td>{{m.director}}</td>
	    </tr>
	   </table>
	  </div>
	  <div class="col-sm-4" id="movie2">
	  
	  </div>
	  <div class="col-sm-4" id="movie3">
	  
	  </div>
	 </div>
	</div>
	<script>
	/*
		Model이 변경되면 View가 갱신된다
		Model => View => ViewModel => Model => View
		데이터			 데이터 관리	  변경된 데이터를 HTML로 전송
						 수정/변경
	*/
	 let movie1=Vue.createApp({
		 // Model => 데이터 관리 => 화면에 출력하는 데이터 출력
		 // 서버 => request, model을 이용해서 전송 => 보내주는 데이터를 설정
		 data(){
			 return {
				 
			 }
		 },
		 // ViewModel => 데이터를 변경해서 화면 출력을 하는 곳
		 // MVVM => VueJs의 디자인 패턴
		 mounted(){
			 
		 },
		 methods:{
			 
		 }
	 })
	</script>
</body>
</html>