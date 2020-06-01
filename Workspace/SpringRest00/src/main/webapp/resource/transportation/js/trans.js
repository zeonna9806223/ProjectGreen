(function ($) {
    'use strict';

    var roberto_window = $(window);

    // ****************************
    // :: 1.0 Preloader Active Code
    // ****************************

    roberto_window.on('load', function () {
        $('#preloader').fadeOut('1000', function () {
            $(this).remove();
        });
    });
})(jQuery);