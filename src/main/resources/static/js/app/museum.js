var main = {
    init : function() {
        var _this = this;
        $('#btn-museum-save').on('click', function () {
            _this.save();
        });

    },

    save : function() {
        var data = {
            museum_name: $('#museum_name').val(),
            museum_phone: $('#museum_phone').val(),
            museum_addr: $('#museum_addr').val(),
            museum_web: $('#museum_web').val(),
            museum_open: $('#museum_open').val(),
            museum_close: $('#museum_close').val(),
            museum_lat: $('#museum_lat').val(),
            museum_lon: $('#museum_lon').val(),
            museum_info: $('#museum_info').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/museum',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('등록되었습니다');
            window.location.href= '/';
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    } // save : function() END


};

main.init();