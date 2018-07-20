<?xml version="1.0"?>
<globals>
    <#include "../common/common_globals.xml.ftl" />
    <global id="resOut" value="${resDir}" />
    <global id="srcOut" value="${srcDir}/${slashedPackageName(packageName)}" />
    <global id="activityOut" value="${srcDir}/${slashedPackageName(packageName)}/activity" />
    <global id="vmOut" value="${srcDir}/${slashedPackageName(packageName)}/mvvm/viewmodel" />
    <global id="bindingModelOut" value="${srcDir}/${slashedPackageName(packageName)}/mvvm/bindingmodel" />
</globals>
