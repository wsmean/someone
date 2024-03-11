   
//로그인 클릭시 db에서 데이터 가져와서 비교   
function login_click(){
	//
	
	id= $("#id_").val();
	pw= $("#pw_").val();
	console.log(id);
	console.log(pw);
	
	//로그인id, pw이 db에 있으면 승인 아니면 알림("아이디 정보가 없습니다")
	$.ajax({
		type : "get",
		async : false,
		dataType : "text",
		url : "http://localhost:8080/login.vm",
		//보내는 데이터
		data: {
			id_: id,
			pw_: pw
		},
		//날라오는 데이터
		success : function(data, textStatus) {
			console.log("받은 data는  "+data);
			console.log("받은 textStatus는 :"+textStatus);
			
			if(data.length > 0){
				alert("로그인 성공!");
				$(location).attr("href","question.html");
				//로컬에 아이디 정보 저장하기
				localStorage.setItem('my_id',data);
				//connect 정보도 가져오기
				
			}else{
				alert("아이디 정보가 없습니다.\n 회원가입을 진행해주세요");
				$("#id_").val("");
				$("#pw_").val("");
			}
							
		},
		error : function(data, textStatus) {
			console.log("에러가 발생")
			alert("올바른 정보를 입력해주세요.");
		},
		complete : function(data, textStatus) {
			
			
		
		}

	});
	
}

