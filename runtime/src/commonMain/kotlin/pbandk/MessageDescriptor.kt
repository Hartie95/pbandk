package pbandk

import kotlin.js.JsExport
import kotlin.reflect.KClass

@JsExport
class MessageDescriptor<T : Message> @PublicForGeneratedCode constructor(
    /**
     * The message type's fully-qualified name, within the proto language's namespace. This differs from
     * the Kotlin name. For example, given this `.proto`:
     *
     * ```proto
     *   package foo.bar;
     *   option java_package = "com.example.protos"
     *   message Baz {}
     * ```
     *
     * `Baz`'s [fullName] is "foo.bar.Baz".
     */
    internal val fullName: String,

    internal val messageClass: KClass<T>,

    @ExperimentalProtoReflection
    val messageCompanion: Message.Companion<T>,

    @ExperimentalProtoReflection
    val fields: Collection<FieldDescriptor<T, *>>
) {
    /** The message type's unqualified name. */
    internal val name = fullName.substringAfterLast('.')
}
