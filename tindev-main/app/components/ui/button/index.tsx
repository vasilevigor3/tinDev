import { memo, forwardRef, createElement } from "react";
import cn from "classnames";
import type { Ref, MouseEventHandler } from "react";

import type { DefaultProps } from "app/components/ui/types";

export type ButtonBaseProps = {
  text?: string;
} & DefaultProps;

export type ButtonProps = {
  type?: "button" | "submit" | "reset";
  onClick?: MouseEventHandler<HTMLButtonElement>;
} & ButtonBaseProps &
  JSX.IntrinsicElements["button"];

export default memo(
  forwardRef(
    (
      {
        as = "button",
        text,
        children = text,
        className,
        baseCn,
        ...props
      }: ButtonProps,
      ref: Ref<HTMLButtonElement>
    ) =>
      createElement(
        as,
        {
          type: "button",
          ref,
          className: cn("btn", className, baseCn),
          ...props,
        },
        children
      )
  )
);
