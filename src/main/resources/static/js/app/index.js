var main = {
    init: function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-update').on('click',function () { //1. btn-update라는 html 엘리먼트에 click 이벤트가 발생할 때 update function을 실행하도록 이벤트 등록
            _this.update();
        });

        $('#btn-delete').on('click',function () {
            _this.delete();
        })
    },
    save: function () {
        var data = {
            title: $('#title').val(),
            writer: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    //update function
    update : function () { //2
        var data = {
            title: $('#title').val(),
            content : $('#content').val()
        };
        var id = $('#id').val();

        $.ajax({
            type : 'PUT', //3. PUT을 사용. rest에서 create - POST, read - GET, update = PUT, delete - DELETE
            url : '/api/v1/posts/' +id, //4 어느 게시글을 수정할지 URL path로 구분하기 위해 Path에 id를 추가함.
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function(){
            alert('글이 수정되었습니다.');
            window.location.href='/';
        }).fail(function(err){
            alert(JSON.stringify(err));
        });
    },

    delete : function () {
        var id= $('#id').val();

        $.ajax({
            type : "DELETE",
            url : "/api/v1/posts/"+id,
            dataType : 'json',
            contentType : 'application/json; charset=utf-8'
        }).done(function(){
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    }
};

main.init();