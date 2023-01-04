"use client";
import Head from "next/head";
import { usePathname } from "next/navigation";
import { capitalize } from "lodash-es";
import cn from "classnames";

import { Link } from "./components/ui";
import stubbyData, { Vacancy } from "stubby.ts";

export default function Home() {
  const pathname = usePathname();

  return (
    <>
      <Head>
        <title>Tindev</title>
        <meta
          name="description"
          content="Best tool to find a job effortlessly"
        />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="icon" href="/favicon.ico" />
      </Head>
      <main>
        <nav className="flex gap-3 container mb-3">
          {["vacancies", "your data", "site settings"].map((tabItem) => (
            <Link
              key={tabItem}
              text={capitalize(tabItem)}
              to={tabItem}
              baseCn="relative text-secondary py-2 px-3 rounded"
              className={
                tabItem === "vacancies"
                  ? "active-tab text-base"
                  : "hover:bg-secondary hover:text-base"
              }
            />
          ))}
          <style jsx global>{`
            .active-tab:before {
              content: "";
              display: block;
              position: absolute;
              height: 0;
              width: 75%;
              border: 0;
              left: 50%;
              right: 50%;
              transform: translateX(-50%);
              bottom: -0.85rem;
              border-bottom: 2px solid;
            }
          `}</style>
        </nav>
        <div className="bg-primary py-4 border-top border-bottom">
          <table className="container table-auto mt-5 text-left border-separate border-spacing-y-2">
            <thead>
              <tr className="[&>*]:max-w-[2rem]">
                <th />
                <th>Company name</th>
                <th>Status</th>
                <th>
                  Required
                  <br /> seniority
                </th>
                <th>
                  Required
                  <br /> experience
                </th>
                <th>Salary</th>
                <th />
              </tr>
            </thead>
            <tbody>
              {(stubbyData as Vacancy[]).map(
                (
                  {
                    id,
                    companyName,
                    seniority,
                    experience,
                    salary,
                    companyStatus,
                  },
                  i
                ) => (
                  <tr
                    key={id}
                    className="[&>*]:max-w-[2.5rem] [&>*]:py-5 [&>*]:border-b [&>*]:border-dashed [&>*]:border-gray border-dotted"
                  >
                    <td>
                      <strong>{i + 1}</strong>
                    </td>
                    <td className="text-lg">{companyName}</td>
                    <td className="!max-w-[5rem]">
                      {(function () {
                        const { status, interview, testAssignment } =
                          companyStatus;

                        if (Boolean(interview)) {
                          return (
                            <div>
                              <p>
                                Interview scheduled for: <br /> {interview.date}
                              </p>
                              <p>
                                Link to the meeting: <br />{" "}
                                {interview.linkToMeeting}
                              </p>
                            </div>
                          );
                        }

                        if (Boolean(testAssignment)) {
                          return (
                            <div>
                              <p>
                                Deadline for your test assignment:
                                <br />
                                {testAssignment.deadline}
                              </p>
                              <p>
                                Link to the assignment:
                                <br />
                                {testAssignment.linkToAssignment}
                              </p>
                            </div>
                          );
                        }

                        return (
                          <span
                            className={cn("font-bold", {
                              "text-green": status === "accepted",
                              "text-red": status === "rejected",
                              "text-yellow": status === "pending",
                            })}
                          >
                            {status}
                          </span>
                        );
                      })()}
                    </td>
                    <td>{seniority}</td>
                    <td>{experience}</td>
                    <td>{salary}</td>
                    <td>Expand</td>
                  </tr>
                )
              )}
            </tbody>
          </table>
        </div>
      </main>
    </>
  );
}
