package pbandk.protobufjs

import pbandk.internal.binary.AbstractSizer

internal object ProtobufJsSizer : AbstractSizer() {
    override fun stringSize(value: String) = util.utf8.length(value).let { it + uInt32Size(it) }
}