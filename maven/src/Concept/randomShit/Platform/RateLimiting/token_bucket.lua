-- KEYS[1]: user key, ARGV[1]: max_tokens, ARGV[2]: refill_rate, ARGV[3]: now (timestamp)
local tokens = tonumber(redis.call("get", KEYS[1]) or ARGV[1])
local last = tonumber(redis.call("get", KEYS[1]..":ts") or ARGV[3])
local delta = math.max(0, ARGV[3] - last)
tokens = math.min(ARGV[1], tokens + delta * ARGV[2])
if tokens < 1 then
  return 0
else
  redis.call("set", KEYS[1], tokens - 1)
  redis.call("set", KEYS[1]..":ts", ARGV[3])
  return 1
end