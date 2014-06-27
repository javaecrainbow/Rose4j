/**
 *
 */
function inforcheck(){

        var user_name = $.trim($('#userName').val());
        if('' == user_name){
            $('#login_error').html('请输入您的帐号');
            $('#userName').focus();
            return false;
        }
        var password = $.trim($('#password').val());
        if('' == password){
            $('#login_error').html('请输入您的密码');
            $('#password').focus();
            return false;
        }
//        if ($('#vericode').length > 0) {
//            var vericode = $.trim($('#vericode').val());
//            if ('' == vericode) {
//                $('#login_error').html('请输入您的验证码');
//                $('#vericode').focus();
//                return false;
//            }
//        }
//        if ($('#dynamickey').length > 0) {
//            var dynamic_key = $.trim($('#dynamickey').val());
//            if ('' == dynamic_key) {
//                $('#login_error').html('请输入您的动态密码');
//                $('#dynamickey').focus();
//                return false;
//            }
//        }

        return true;
    }

    function checkform(){

        if(!inforcheck() || $('#login_form').data('submiting')) return false;

		$('#login_form').data('submiting', true);
        return true;
    }

    function signOff(e){

        if($(this).data('signoffing')) return;

        if(!inforcheck()) return;

        $(this).data('signoffing', true);

        var _this   = $(this);
		var user_name = $('#username').val();
		var mic_key = $('#dynamickey').val();
        $.post(_this.attr('confirm-url'), {mickey : mic_key, username : user_name}, function(cb){

            var msg = '当前服务器时间 ' + cb.data + '，确定要签退么？';
            if(confirm(msg)){

                $.ajax({
                    url        : _this.attr('action-url'),
                    data       : {
                        username: user_name,
                        password: $('#password').val(),
                        dynamickey: mic_key
                    },
                    dataType   : 'json',
                    success    : function(cb){

                        _this.data('signoffing', false);

                        if(1 == cb.status){

                            $('#login_content_box').html(cb.data);
                        }else{

                            $('#' + cb.data).focus();
                            $('#login_error').html(cb.info);
                        }
                    },
                    timeout    : 10000,
                    type       : 'post',
                    error      : function (XMLHttpRequest , textStatus , errorThrown) {
                        alert('操作失败，请重试' );
                    }
               });
            }else{

                _this.data('signoffing', false);
            }
        },'json');
    }

    function getNewVerifyImage(e){

        $('#verify_code_image').attr('src', $(this).attr('src') + '?t=' + Math.floor(Math.random()*1000000) );
    }