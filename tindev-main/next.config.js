/** @type {import('next').NextConfig} */
const nextConfig = {
  reactStrictMode: true,
  eslint: {
    ignoreDuringBuilds: true, //TODO: remove when lint errors are fixed
  },
  typescript: {
    ignoreBuildErrors: true, //TODO: remove when type errors are fixed
  },
  experimental: {
    appDir: true,
  },
};

module.exports = nextConfig;
