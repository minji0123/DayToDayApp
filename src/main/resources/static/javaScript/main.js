// 체크박스
$("input:checkbox[value='true']").prop("checked",true); // 채크됨
$("input:checkbox[value='false']").prop("checked",false); //체크안됨

function checkbox_Checked(this_checkbox){
    console.log(this_checkbox);
    console.log($(this_checkbox));

    const checked = $(this_checkbox).prop("checked");
    const id = $(this_checkbox).prop("id");

    console.log(checked);
    console.log(id);

    const checkbox_status = {  // Json 키 값 = Dto 키 값
        "id" : id,
        "completed" : checked
    };
    console.log(checkbox_status);

    // fetch() - 수정 REST API 호출
    const url = "/daytoday/update/" +checkbox_status.id;
    fetch(url, {
        method: "PATCH",                         // PATCH 요청을 보낼거다.
        body: JSON.stringify(checkbox_status),          // comment JS 객체(수정된 댓글)을 JSON 으로 바꿔서 보낸다.
        headers: {
            "Content-Type": "application/json" // body 에 실어서 보낸게 application/json 타입이다. (여기 안에는 json 이 들어있엉)
        }
    }).then(response => {
            // http 응답 코드에 따른 메세지 출력
            const msg = (response.ok)? "체크박스가 수정되었습니다." : "체크박스 수정 실패!";
            window.location.reload();
     });

}// function

// 게시글 삭제
const deleteBtns = document.querySelectorAll(".delete-btn");

deleteBtns.forEach(btn => {

    // 각 버튼의 이벤트 처리 등록
    btn.addEventListener("click", (event) => {

        const deleteBtn = event.srcElement; // 현재 클릭된 버튼

        const dtdId = deleteBtn.getAttribute("data-id"); // 삭제할 할 일 id 가져오기
        console.log(`삭제 버튼 클릭: ${dtdId}번 할 일`);

        const url = `/daytoday/delete/${dtdId}`;
        fetch(url, {
            method: "delete",
        }).then(response => {

            if (!response.ok){
                alert("할 일 삭제 실패!");
                return;
            }

            const target = document.getElementById(`${dtdId}`);
            target.remove();
            window.location.reload();


        });
    });
});


// 새 할 일 등록
const commentBtn = document.querySelector("#comment-create-btn");

commentBtn.addEventListener("click", () => {
    // 새 할일 객체 생성
    const comment = {
        title: document.querySelector("#new-comment-title").value,
        completed: document.querySelector("#new-comment-completed").value
    };
    // 할일 객체 출력
    console.log(comment);

    // fetch Talend API 요청을 JavaScript 로 보내준다.
    const url = "/daytoday/create";
    fetch(url, {
        method: "post",
        body: JSON.stringify(comment),
        headers: {
            "Content-Type": "application/json"  // body 에 실어서 보낸게 application/json 타입이다. (여기 안에는 json 이 들어있엉)
        }
    }).then(response => {
        // http 응답 코드에 따른 메세지 출력
        const msg = (response.ok)? "할 일이 등록되었습니다." : "할 일 등록 실패!";
<!--        alert(msg);-->

        // 현재 페이지 새로고침
        window.location.reload();

    });// fetch

}); //addEventListener


// 모달 창 변수화 (버튼 누르면 모달창 뜨게)
const editModal = document.querySelector('#edit-modal');

// 수정 버튼 클릭하면은
editModal.addEventListener("shown.bs.modal", (event) => {
    // 트리거 버튼 변수화
    const triggerBtn = event.relatedTarget;

    // 원래 있던 할 일 불러오기
    const id = triggerBtn.getAttribute("data-bs-id");
    const title = triggerBtn.getAttribute("data-bs-title");
    const completed = triggerBtn.getAttribute("data-bs-completed");

    // 불러온 할 일 반영시키기
    document.querySelector("#edit-modal-id").value = id;
    document.querySelector("#edit-modal-title").value = title;
    document.querySelector("#edit-modal-completed").value = completed;
});

// 수정 완료 버튼 변수화
const editedBtn = document.querySelector("#edit-btn");

// 수정 완료 버튼 클릭하면은
editedBtn.addEventListener("click", () => {
    // 수정 할일 객체 생성
    const editDTD = {
        id : document.querySelector("#edit-modal-id").value,
        title : document.querySelector("#edit-modal-title").value,
        completed : document.querySelector("#edit-modal-completed").value
    };

    // fetch
    const url = "/daytoday/edit/"+ editDTD.id;
    fetch (url, {
        method: "PATCH",
        body:JSON.stringify(editDTD),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(response => {
        const msg = (response.ok)? "할 일이 수정되었습니다." : "할 일 수정 실패!";

        // 현재 페이지 새로고침
        window.location.reload();
    });
});