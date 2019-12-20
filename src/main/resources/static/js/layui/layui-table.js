layui.use('table', function(){
  var table = layui.table;
  
  //方法级渲染
  table.render({
    elem: '#LAY_table_user'
    ,url: '/item/find'
    ,cols:[[
      {checkbox: true, fixed: true}
      ,{field:'id', title: 'ID', width:80, sort: true, fixed: true}
      ,{field:'name', title: '商品名', width:80}
      ,{field:'price', title: '价格', width:80, sort: true}
      ,{field:'status', title: '状态', width:80}
      ,{field:'creat_time', title: '上架时间'}
      ,{field:'wealth', title: '操作', width:135}
    ]]
    ,id: 'testReload'
    ,page: true
    ,height: 310
  });
  
  var $ = layui.$, active = {
    reload: function(){
      var demoReload = $('#demoReload');
      
      //执行重载
      table.reload('testReload', {
        page: {
          curr: 1 //重新从第 1 页开始
        }
        ,where: {
          key: {
            id: demoReload.val()
          }
        }
      }, 'data');
    }
  };
  
  $('.demoTable .layui-btn').on('click', function(){
    var type = $(this).data('type');
    active[type] ? active[type].call(this) : '';
  });
});
