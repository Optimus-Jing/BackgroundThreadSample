# BackgroundThreadSample
如何通过把任务执行在后台线程来提升程序的性能？如何最小化后台线程对电量的消耗？ 1.在后台Service中执行任务  通过发送任务给后台Service来提升UI的性能并避免ANR。  2.在后台加载数据  使用CursorLoader来查询数据，同时避免影响到UI的响应性。  3.管理设备的唤醒状态  使用重复闹钟以及唤醒锁来执行后台任务。
大标题
===
