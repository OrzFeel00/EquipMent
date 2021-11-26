
    var is_empty =1  //控制自我定位开关0就开启
    lng = 114.0645;
    lat = 22.5484;
    var map = new BMap.Map("container");//在指定的容器内创建地图实例
    map.setDefaultCursor("crosshair");//设置地图默认的鼠标指针样式
    map.enableScrollWheelZoom();//启用滚轮放大缩小，默认禁用。
    var point =new BMap.Point(lng,lat)
    map.centerAndZoom(point, 14);
    map.addControl(new BMap.NavigationControl());
    var marker = new BMap.Marker(point);        // 创建标注
    this.map.addOverlay(marker);


    map.addEventListener("click", function(e){//地图单击事件
        var geocoder = new BMap.Geocoder();
        var point = new BMap.Point(e.point.lng,e.point.lat);
        geocoder.getLocation(point,function(geocoderResult,LocationOptions){
            map.clearOverlays()//清除地图上所有覆盖物
            map.addControl(new BMap.NavigationControl());//增加组件
            var marker = new BMap.Marker(point);        // 创建标注
            
            this.map.addOverlay(marker);
            //定位成功
            var address = geocoderResult.address;
            document.getElementById("where").value =address
           document.getElementById("whereis").value =address
            layer.msg('定位成功');
            // $('#suggestId').val(geocoderResult.address);
        });
        document.getElementById("lng").value = e.point.lng;
        document.getElementById("lat").value = e.point.lat;
    });
    function iploac(result){//根据IP设置地图中心
        var cityName = result.name;
        map.setCenter(cityName);
    }
    if(is_empty ==0){
        // var myCity = new BMap.LocalCity();
        // myCity.get(iploac);
        dingwei()

    }
    function dingwei() {//自我定位
        var geolocation = new BMap.Geolocation();
        geolocation.getCurrentPosition(function(r){
            if(this.getStatus() == BMAP_STATUS_SUCCESS){
                var mk = new BMap.Marker(r.point);
                map.addOverlay(mk);
                map.panTo(r.point);
                document.getElementById("lng").value = r.point.lng;
                document.getElementById("lat").value = r.point.lat;
                var city_name =r.address.province + r.address.city;
                document.getElementById("where").value = city_name
            }
            else {
                console.log('获取失败');
            }
        });
    }

    function sear(result){//地图搜索
        if(result.length ==0){
            dingwei();
            return false
        }
        var local = new BMap.LocalSearch(map, {
            renderOptions:{map: map}
        });
        local.search(result);
    }
