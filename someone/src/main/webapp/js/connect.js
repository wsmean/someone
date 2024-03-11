//프로필 아이디 맞춰서 변경
const p_id = localStorage.getItem('my_id');
const couple_connect_r = localStorage.getItem('couple_connect');

window.onload = function(){
	console.log(p_id);
	$('#profile_id').text(p_id);
	
	//만약 연결이 되있을 경우 버튼 비활성화
	if(couple_connect_r != null){
		$("#couple_connect").attr("disabled", true);
		$("#couple_connect").css({'background-color': 'rgb(255, 190, 233)'})
		$("#h2img").attr("src","images/loveu.png");
		$("#h2img").css({'width': "400px"});
		$("#h2id").text("이미 상대방과 연결 되어있습니다!");
		$("#input_id").hide();
		$("#couple_connect").hide();
		
	}else{
		$("#couple_disconnect").attr("disabled", true);
	}
}


function log_out(){
	alert("로그아웃이 완료 되었습니다");
	location.href="index.html"
	localStorage.clear();
}

//회원 탈퇴
function join_out(){
        if(confirm("탈퇴하시겠습니까?\n탈퇴시 모든 정보가 사라집니다.")){
            alert('탈퇴가 완료 되었습니다.');
            //탈퇴시 모든 정보 삭제 (아이디+랜덤 질문 답변한거)
            $.ajax({
                type : "get",
                async : false,
                dataType : "text",
                url : "http://localhost:8080/deleteMembers1.vm",
                data : {
                    j_id1: p_id
                },
                success: function(data, textStatus) {
                	console.log("Ajax에서 받은 값 : "+data);
                	console.log("성공");
                },
                error: function(data, textStatus) {
                    console.log("에러가 발생")
                },
                complete: function(data, textStatus) {
                    console.log("전송 완료되었습니다.")
                }
            });	    
            localStorage.clear();
            location.href="index.html"
            
        }else{
            alert('탈퇴가 취소 되었습니다.');
            //굳이 안써도됨 location.reload(true);쓰면 새로고침이라 정보 날아감
        }
    }
        
let random_question;   
 
//random_quesiton 데이터 호출
function loadDBData() {
	$.ajax({
		type : "get",
		async : false,
		dataType : "text",
		url : "http://localhost:8080/loadrandom_question.vm",
		success : function(data, textStatus) {
			random_question = JSON.parse(data);
			console.log(random_question);
			$("#question").text(random_question[0].question);
			$("#create_ran").attr("disabled", true);	
			$("#create_ran").css({'background-color': 'rgb(255, 190, 233)'});
		},
		error : function(data, textStatus) {
			console.log("에러가 발생")
		},
		complete : function(data, textStatus) {
			console.log("전송 완료되었습니다.")
		}

	});
}

//member 디비에 들어가서 아이디가 있으면 연결 하시겠습니까? confirm 하고 연결
function connect_couple(){
		
		console.log($("#input_id").val());
		const nickname = $("#input_id").val();
		
		if(nickname == ""){
			alert("아이디를 입력해주세요!");
		}else{
			if(confirm(nickname+'님과 연결하시겠습니까?')){
			
			//답변 저장
			$.ajax({
			type: "get",
			async: false,
			dataType: "text",
			url: "http://localhost:8080/check_id.vm",
			//보내는 데이터
			data: {
				c_id: nickname,
				m_id : p_id
				
			},
			//날라오는 데이터
			success: function(data, textStatus) {
				console.log('확인한 아이디는'+data);
				if(data === "true"){
					alert("연결이 완료 되었습니다.");
					$("#couple_connect").attr("disabled", true);
					$("#couple_connect").css({'background-color': 'rgb(255, 190, 233)'});
					localStorage.setItem('couple_connect',data);
				}else if(data === "same"){
					alert("이미 연결 된 아이디 입니다!\n 다른 아이디를 입력해주세요!")
					$('#input_id').val("");
				}else{
					alert("연결 가능한 아이디가 없습니다.\n 아이디를 다시 입력해주세요!");
					$('#input_id').val("");
				}	
			},
			error: function(data, textStatus) {
				console.log("에러가 발생")
			},
			complete: function(data, textStatus) {
				console.log("전송 완료되었습니다.")
			}
			});	
				
			
		}else{
			alert('연결이 취소되었습니다');
		};
		}
		
	
}

function disconnect_couple(){
	if(confirm("정말로 해지하겠습니까?\n커플 정보는 사라지며 복구 할 수 없습니다.")){
		alert("커플 연결이 해제되었습니다."); 
	}else{
		alert("커플 연결 해제를 취소하였습니다");
	}
	
}


