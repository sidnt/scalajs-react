package japgolly.scalajs.react

import japgolly.scalajs.react.internal.Effect

package object test {

  val Simulate = japgolly.scalajs.react.test.raw.ReactTestUtils.Simulate

  type ReactOrDomNode = japgolly.scalajs.react.test.raw.ReactOrDomNode

  implicit def reactOrDomNodeFromMounted(m: GenericComponent.MountedRaw): ReactOrDomNode =
    ReactDOM.raw.findDOMNode(m.raw)

  implicit def reactOrDomNodeFromVRE(m: vdom.VdomElement): ReactOrDomNode =
    m.rawElement

  implicit final class ReactTestExt_MountedId(private val c: GenericComponent.MountedWithRoot[Effect.Id, _, _, _, _]) extends AnyVal {
    def outerHtmlWithoutReactDataAttr(): String =
      ReactTestUtils.removeReactDataAttr(c.getDOMNode.outerHTML)
  }
}
