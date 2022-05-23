/**
 * 
 */
var reviewService = (function() {

    var getList = function(param, callback, error, before, after) {
        var sno = param.sno;
        var lastRno = param.lastRno || 10000000000;
        var amount = param.amount || 10;

        console.log("getList()..");
        var url = "/reviews/pages/" + sno + "/" + lastRno + "/" + amount;

        $.ajax({
            url: url,
            type: "get",
			dataType:"json",
			beforeSend : function() {
				if(before) {
					before();
				}
			},
            success: function(result, status, xhr) {
                if(callback){
                	callback(result);
                }
                if(after) {
                	after(result);
                }
            },
            error: function(xhr, status, er) {
                if(error) error(er);
            }
        })
    }

    function displayTime(timeValue) {
        console.log("displayTime()..");
        moment.locale('ko');
        return moment(timeValue).fromNow();
    }
    
    return {
        getList: getList, 
        displayTime: displayTime
    };
})();


var replyService = (function() {
	var getOrderMenus = function(onum, callback) {
		$.ajax({
			url : "/order/findorder/" + onum,
			type : "get",
			dataType : "json",
			success : function(result) {
				if(callback) {
					callback(result);
				}
			}
		})
	}

	return {getOrderMenus : getOrderMenus}
})();