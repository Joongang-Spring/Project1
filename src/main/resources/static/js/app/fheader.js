/*fheader.js*/

$( function () {

    /*
     * header
     */
    $( '.header' ).each( function () {

        var $window = $( window ), 
            $header = $( this ),
            $h1 = $('h1'), $divul = $('.gnb>ul'),
            // 헤더 기본 위치 검색
            headerOffsetTop = $header.offset().top;

        
        // 스크롤 될 때마다 실행
        $window.on( 'scroll', function () {
            
            /*스크롤 위치 확인*/
            // 헤더의 기본 위치를 지나면 클래스 부여            
            if ( $window.scrollTop() > headerOffsetTop ) {
                $header.addClass( 'hdtop' );
                $h1.css("margin-top","15px").css("transition","margin-top 0.5s ease 0.1s");
                $divul.css("margin-top","30px").css("transition","margin-top 0.1s ease 0s");
            } else {    // 그렇지 않으면 삭제
                $header.removeClass( 'hdtop' );
                $h1.css("margin-top","24px").css("transition","margin-top 0.5s ease 0.1s");
                $divul.css("margin-top","39px").css("transition","margin-top 0.1s ease 0s");
            }
        } );

        
        // 헤더의 초기 위치 조정
        $window.trigger( 'scroll' );

    } );
} );
