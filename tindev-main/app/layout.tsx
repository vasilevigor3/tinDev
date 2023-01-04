"use client";
import Image from "next/image";
import { Inter } from "@next/font/google";

import { Link } from "./components/ui";
import logo from "public/logo.png";
import "../styles/globals.css";

const inter = Inter({ subsets: ["latin"] });

function Header() {
  return (
    <header className="h-[5.7rem] mb-5">
      <div className="container h-full flex items-center justify-between">
        <Link to="/" className="flex-center gap-2 text-[3rem]">
          <Image src={logo.src} alt="Logo" width={40} height={40} />
          Tindev
        </Link>
        <Link
          to="/"
          text="Log in"
          className="contained bg-green text-white rounded-[2rem]"
        />
      </div>
    </header>
  );
}

export default function RootLayout({ children }) {
  return (
    <html lang="en">
      <body className={inter.className + " light"}>
        <Header />
        {children}
      </body>
    </html>
  );
}
