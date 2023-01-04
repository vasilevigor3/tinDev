enum Carrier {
  frontend = "frontend",
  backend = "backend",
  qa = "qa",
  design = "design",
}
enum Seniority {
  junior = "junior",
  middle = "middle",
  senior = "senior",
}
type Status = "rejected" | "accepted" | "pending";

interface CompanyStatus {
  status: Status;
  interview: {
    date: string;
    linkToMeeting: string;
  } | null;
  testAssignment: {
    deadline: string;
    linkToAssignment: string;
  } | null;
}

enum JobPlatform {
  telegram = "Telegram",
  linkedin = "LinkedIn",
  glassdoor = "Glassdoor",
  hh = "HH",
  monster = "Monster",
  indeed = "Indeed",
}

export interface Vacancy {
  id: string;
  salary: string;
  companyStatus: CompanyStatus;
  jobTitle: Carrier;
  userStatus: Status;
  seniority: string;
  experience: string;
  companyName: string;
  description: string;
  userIds: string[];
  location: string;
  jobPlatform: JobPlatform;
}

export default [
  {
    salary: "$1000",
    id: "1",
    companyStatus: {
      status: "pending",
      interview: {
        date: "02/05/2020",
        linkToMeeting: "https://example.com/meeting",
      },
      testAssignment: null,
    },
    jobTitle: Carrier.frontend,
    userStatus: "accepted",
    seniority: Seniority.junior,
    experience: "3 years",
    companyName: "Apple",
    description:
      "We are looking for an experienced Frontend Developer to join our team.",
    userIds: ["user01", "user02"],
    location: "USA",
    jobPlatform: JobPlatform.telegram,
  },
  {
    salary: "$1000",
    id: "2",
    companyStatus: {
      status: "rejected",
    },
    jobTitle: Carrier.backend,
    userStatus: "pending",
    seniority: Seniority.middle,
    experience: "5 years",
    companyName: "Google",
    description:
      "We are looking for an experienced Backend Developer to join our team.",
    userIds: ["user03", "user04"],
    location: "USA",
    jobPlatform: JobPlatform.linkedin,
  },
  {
    salary: "$1000",
    id: "3",
    companyStatus: {
      status: "pending",
      interview: null,
      testAssignment: {
        deadline: "12/05/2020",
        linkToAssignment: "https://example.com/assignment",
      },
    },
    jobTitle: Carrier.qa,
    userStatus: "accepted",
    seniority: Seniority.senior,
    experience: "7 years",
    companyName: "Amazon",
    description:
      "We are looking for an experienced QA Engineer to join our team.",
    userIds: ["user05", "user06"],
    location: "USA",
    jobPlatform: JobPlatform.glassdoor,
  },
  {
    salary: "$1000",
    id: "4",
    companyStatus: {
      status: "pending",
      interview: {
        date: "14/05/2020",
        linkToMeeting: "https://example.com/meeting",
      },
      testAssignment: null,
    },
    jobTitle: Carrier.design,
    userStatus: "rejected",
    seniority: Seniority.middle,
    experience: "4 years",
    companyName: "Facebook",
    description: "We are looking for an experienced Designer to join our team.",
    userIds: ["user07", "user08"],
    location: "USA",
    jobPlatform: JobPlatform.hh,
  },
  {
    salary: "$1000",
    id: "5",
    companyStatus: {
      status: "accepted",
      interview: null,
      testAssignment: null,
    },
    jobTitle: Carrier.frontend,
    userStatus: "pending",
    seniority: Seniority.junior,
    experience: "2 years",
    companyName: "Microsoft",
    description:
      "We are looking for an experienced Frontend Developer to join our team.",
    userIds: ["user09", "user10"],
    location: "USA",
    jobPlatform: JobPlatform.monster,
  },
  {
    salary: "$1000",
    id: "6",
    companyStatus: {
      status: "pending",
      interview: {
        date: "25/05/2020",
        linkToMeeting: "https://example.com/meeting",
      },
      testAssignment: null,
    },
    jobTitle: Carrier.backend,
    userStatus: "rejected",
    seniority: Seniority.senior,
    experience: "6 years",
    companyName: "IBM",
    description:
      "We are looking for an experienced Backend Developer to join our team.",
    userIds: ["user11", "user12"],
    location: "USA",
    jobPlatform: JobPlatform.telegram,
  },
  {
    salary: "$1000",
    id: "7",
    companyStatus: {
      status: "pending",
      interview: null,
      testAssignment: {
        deadline: "02/06/2020",
        linkToAssignment: "https://example.com/assignment",
      },
    },
    jobTitle: Carrier.qa,
    userStatus: "accepted",
    seniority: Seniority.middle,
    experience: "5 years",
    companyName: "Airbnb",
    description:
      "We are looking for an experienced QA Engineer to join our team.",
    userIds: ["user13", "user14"],
    location: "USA",
    jobPlatform: JobPlatform.linkedin,
  },
  {
    salary: "$1000",
    id: "8",
    companyStatus: {
      status: "pending",
      interview: null,
      testAssignment: null,
    },
    jobTitle: Carrier.design,
    userStatus: "pending",
    seniority: Seniority.junior,
    experience: "3 years",
    companyName: "Uber",
    description: "We are looking for an experienced Designer to join our team.",
    userIds: ["user15", "user16"],
    location: "USA",
    jobPlatform: JobPlatform.glassdoor,
  },
] as Vacancy[];
