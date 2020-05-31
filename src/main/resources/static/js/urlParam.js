
    function getRequest() {
        var url = location.search; //获取url中"?"符后的字串
        var theRequest = new Object();
        if(url.indexOf("?") != -1) {
            var str = url.substr(1);
            strs = str.split("&");
            for(var i = 0; i < strs.length; i++) {
                theRequest[strs[i].split("=")[0]] = decodeURI(strs[i].split("=")[1]);
            }
        }
        return theRequest;
    }

    function replaceParamVal(paramName,replaceWith) {
        var oUrl = this.location.href.toString();
        var re=eval('/('+ paramName+'=)([^&]*)/gi');
        var nUrl = oUrl.replace(re,paramName+'='+replaceWith);
        this.location = nUrl;
    　　window.location.href=nUrl
    }
