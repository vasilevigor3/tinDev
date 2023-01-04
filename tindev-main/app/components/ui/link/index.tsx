import Link from "next/link";
import { memo, forwardRef } from "react";
import cn from "classnames";
import type { LinkProps as NextLinkProps } from "next/link";
import type { Ref } from "react";

import type { ButtonBaseProps } from "app/components/ui/button";

export type LinkProps = {
  to: NextLinkProps["href"];
  newTab?: boolean;
} & Omit<NextLinkProps, "href"> &
  ButtonBaseProps;

export default memo(
  forwardRef(
    (
      {
        to,
        text,
        children = text,
        newTab,
        className,
        baseCn,
        ...props
      }: LinkProps,
      ref: Ref<HTMLAnchorElement>
    ) => (
      <Link
        target={newTab ? "_blank" : undefined}
        rel={newTab ? "noreferrer" : undefined}
        className={cn("btn", className, baseCn)}
        href={to}
        aria-label={to as string}
        ref={ref}
        {...props}
      >
        {children}
      </Link>
    )
  )
);
