<?xml version="1.0"?>
<globals>
    <#include "../common/common_globals.xml.ftl" />
    <global id="resOut" value="${resDir}" />
    <global id="srcOut" value="${srcDir}/${slashedPackageName(packageName)}" />
    <global id="fragmentOut" value="${srcDir}/${slashedPackageName(packageName)}/fragment" />
    <global id="vmOut" value="${srcDir}/${slashedPackageName(packageName)}/viewmodel" />
    <global id="bindingModelOut" value="${srcDir}/${slashedPackageName(packageName)}/models/binding" />
</globals>
